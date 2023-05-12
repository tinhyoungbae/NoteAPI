package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.Text;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Repository.FriendRepository.interfaceTextRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class textService implements interfaceTextService{
    @Autowired
    interfaceTextRepository interfaceTextRepository;
    @Override
    public ResponseEntity<Response> getTextList() {
        List<Text> textList = interfaceTextRepository.findAll();
        if(!textList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all text", textList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> getTextByID(int textID) {
        Optional<Text> textOptional = interfaceTextRepository.findById(textID);
        if(textOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got a text", textOptional.get())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "There isn't text ID = "+textID +" in database. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> addText(Text text) {
        if (text != null) {
            interfaceTextRepository.save(text);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), text)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateText(Text text) {
        List<Text> textList = interfaceTextRepository.findAll();
        if(!textList.isEmpty()){
            interfaceTextRepository.save(text);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", text)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update text. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteText(int textID) {
        Optional<Text> textOptional = interfaceTextRepository.findById(textID);
        if(textOptional.isPresent()){
            interfaceTextRepository.delete(textOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getTextList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getTextList().getBody().getData())
            );
        }
    }
}

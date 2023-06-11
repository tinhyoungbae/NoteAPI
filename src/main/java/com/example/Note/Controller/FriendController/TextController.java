package com.example.Note.Controller.FriendController;

import com.example.Note.Model.FriendModel.Text;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.FriendService.textService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TextController {
    @Autowired
    textService textService;

    // return list text
    @GetMapping("/text")
    public ResponseEntity<Response> getTextList(){
        return textService.getTextList();
    }

    // add a text
    @PutMapping("/text/{userID}")
    public Text addText(@PathVariable int userID, @RequestBody Text text){
        return textService.addText(userID, text);
    }

    // find a text
    @GetMapping("/text/{textID}")
    public ResponseEntity<Response> getTextByID(@PathVariable int textID){
        return textService.getTextByID(textID);
    }

    // update a text
    @PutMapping("/text")
    public ResponseEntity<Response> updateText(@RequestBody Text text){
        return textService.updateText(text);
    }

    // delete a text
    @DeleteMapping("/text/{textID}")
    public ResponseEntity<Response> deleteText(@PathVariable int textID) {
        return textService.deleteText(textID);
    }
}

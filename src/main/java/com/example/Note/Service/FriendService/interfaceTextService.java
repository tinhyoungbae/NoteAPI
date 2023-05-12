package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.Text;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

public interface interfaceTextService {
    public ResponseEntity<Response> getTextList();
    public ResponseEntity<Response> getTextByID(int textID);
    public ResponseEntity<Response> addText(Text text);
    public ResponseEntity<Response> updateText(Text text);
    public ResponseEntity<Response> deleteText(int textID);
}

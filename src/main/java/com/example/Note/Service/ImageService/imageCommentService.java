package com.example.Note.Service.ImageService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.ImageModel.imageComment;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Repository.FriendRepository.interfaceCommentRepository;
import com.example.Note.Repository.ImageRepository.interfaceImageCommentRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Service
public class imageCommentService implements interfaceImageCommentService{
    @Autowired
    interfaceImageCommentRepository interfaceImageCommentRepository;
    @Autowired
    interfaceCommentRepository interfaceCommentRepository;

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
    @Override
    public ResponseEntity<Response> getImageCommentList() {
        return null;
    }

    @Override
    public imageComment getImageCommentByID(int imageCommentID) {
        return null;
    }

    @Override
    public ResponseEntity<Response> addImageComment(int commentID, imageComment imageComment, String imageCommentName, MultipartFile imageCommentPath, String imageCommentSize, Timestamp imageCommentCreatedDate) {
        Comment comment = interfaceCommentRepository.findById(commentID).get();
        imageComment.setImageCommentName(imageCommentPath.getOriginalFilename());
        imageComment.setImageCommentPath(imageCommentPath.getName());
        imageComment.setImageCommentSize(imageCommentPath.getSize());
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        imageComment.setImageCommentSizeCreatedDate(currentTimestamp);
        imageComment.setComment(comment);
        interfaceImageCommentRepository.save(imageComment);
        return ResponseEntity.status(HttpStatus.OK).body(
                new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> add a file successfully", imageComment)
        );
    }

    @Override
    public ResponseEntity<Response> updateImageComment(imageComment imageComment) {
        return null;
    }

    @Override
    public ResponseEntity<Response> deleteImageComment(int imageCommentID) {
        return null;
    }
}

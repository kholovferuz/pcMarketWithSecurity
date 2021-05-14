package uz.pdp.pcmarket.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.entity.AttachmentContent;
import uz.pdp.pcmarket.repository.AttachmentContentReposiory;
import uz.pdp.pcmarket.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    final AttachmentRepository attachmentRepository;

    final AttachmentContentReposiory attachmentContentRepository;

    public AttachmentController(AttachmentRepository attachmentRepository,
                                AttachmentContentReposiory attachmentContentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentRepository = attachmentContentRepository;
    }

    @PostMapping("/upload")
    public String uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        // file ni ushlab oladi
        MultipartFile requestFile = request.getFile(fileNames.next());
        if (requestFile != null) {
            // file haqida ma'lumot olish uchun
            String originalFilename = requestFile.getOriginalFilename();
            long size = requestFile.getSize();
            String contentType = requestFile.getContentType();

            Attachment attachment = new Attachment();
            attachment.setFileOriginalName(originalFilename);
            attachment.setSize(size);
            attachment.setContentType(contentType);

            Attachment savedAttachment = attachmentRepository.save(attachment);

            // fileni content (byte[] arrayini) saqlash
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(requestFile.getBytes());
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);
            return "File uploaded. File ID: " + savedAttachment.getId();
        }
        return "Error in uploading file";
    }

    @GetMapping("/download/{id}")
    public void getFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();

            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            AttachmentContent attachmentContent = optionalAttachmentContent.get();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getFileOriginalName() + "\""); // file nomi uchun
            response.setContentType(attachment.getContentType()); // content type uchun

            FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream()); // byte ni berish uchun
        }
    }
}

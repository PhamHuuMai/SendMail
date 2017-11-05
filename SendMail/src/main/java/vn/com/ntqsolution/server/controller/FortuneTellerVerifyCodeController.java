package vn.com.ntqsolution.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.ntqsolution.worker.email.EmailDeliver;

/**
 * @author TungLK
 *
 */
@RestController
@RequestMapping("ums/v1/tellerverifycodes")
public class FortuneTellerVerifyCodeController  {

    @PostMapping()
    public ResponseEntity<Object> receiveVerifyCode() {
        new EmailDeliver().deliver();
        return new ResponseEntity<>("ssssssssssss", HttpStatus.OK);
    }
}

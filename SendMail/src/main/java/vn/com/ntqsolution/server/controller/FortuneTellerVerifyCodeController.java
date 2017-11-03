/**
 *
 */
package vn.com.ntqsolution.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.ntqsolution.server.worker.email.EmailDeliver;


/**
 * @author TungLK
 *
 */
@RestController
@RequestMapping("ums/v1/tellerverifycodes")
public class FortuneTellerVerifyCodeController {

    @PostMapping()
    public ResponseEntity<Object> receiveVerifyCode() {
        (new EmailDeliver()).deliver();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

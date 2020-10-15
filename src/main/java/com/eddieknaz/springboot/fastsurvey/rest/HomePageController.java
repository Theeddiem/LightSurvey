package com.eddieknaz.springboot.fastsurvey.rest;

import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import com.eddieknaz.springboot.fastsurvey.exception.NotFoundException;
import com.eddieknaz.springboot.fastsurvey.service.OptionService;
import com.eddieknaz.springboot.fastsurvey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
public class HomePageController implements ErrorController {
//
@RequestMapping("/error")
public Object error(HttpServletRequest request, HttpServletResponse response) {
    // place your additional code here (such as error logging...)
    if (request.getMethod().equalsIgnoreCase(HttpMethod.GET.name())) {
        response.setStatus(HttpStatus.OK.value()); // optional.
        return "forward:/index.html"; // forward to static SPA html resource.
    } else {
        return ResponseEntity.notFound().build(); // or your REST 404 blabla...
    }
}
    @Override
    public String getErrorPath() {
        return "/error";
    }




}

package com.RESTproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorConroller implements ErrorController {

  @RequestMapping("/error")
  @ResponseBody
  public String handleError(HttpServletRequest request) {
      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
      return String.format("<html><body><h2>Error Page</h2><div><b>Status code:</b> %s</div>"
                      + "<div><b>Exception Message:</b> %s</div><body></html>",
              statusCode, exception.getMessage());
  }

  @Override
  public String getErrorPath() {
      return "/error";
  }
}

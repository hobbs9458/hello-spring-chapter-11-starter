package org.launchcode.hellospring.controllers;

import javax.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//   Handles requests at path /hello
  @GetMapping("hello")
  @ResponseBody
  public String hello() {
    return "Hello, Spring!";
  }

  // Handles requests at path /goodbye
  @GetMapping("goodbye")
  @ResponseBody
  public String goodbye() {
    return "Goodbye, Spring!";
  }

  //handler to handle request of the form /hello?name=LaunchCode
  @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloParam")
  @ResponseBody
  public String helloQueryParam(@RequestParam String coder, @RequestParam String greeting) {
    return greeting + " " + coder + "!";
  }

  //handler with path parameter
  @GetMapping("hello/{name}")
  @ResponseBody
  public String helloPathParam(@PathVariable String name) {

    return "Hello, " + name + "!";
  }

  @GetMapping("form")
  @ResponseBody
  public String helloForm() {
    return "<html>"
          + "<body>"
            + "<form action='helloParam' method='post'>" //submit a request to /hello
              + "<input type='text' name='coder'>"
              + "<input type='submit' value='Greet me!'>"
              + "<select name='greeting'>"
                + "<option value = 'Hello'>"
                + "English"
                + "</option>"
                + "<option value = 'Bonjour'>"
                + "French"
                + "</option>"
                + "<option value = 'Ni hao'>"
                + "Chinese"
                + "</option>"
                + "<option value = 'Konnichiwa'>"
                + "Japanese"
                + "</option>"
                + "<option value = 'Geia sas'>"
                + "Greek"
                + "</option>"
              + "</select"
            + "</form>"
          + "</body>"
        + "</html>";
  }


}

package com.example.springdocsample.web;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {



    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "The job status is complete")

    })
    @GetMapping("/get")
    public String getSample(){
        return "sample";
    }


}

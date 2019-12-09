package com.example.MandelbrotSet.api;


import com.example.MandelbrotSet.service.MandelbrotSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class Controller {

    @Autowired
    MandelbrotSet mandelbrotSet;

   @GetMapping("/mds")
    public void renderMandelbrotSet(HttpServletResponse response) throws IOException {
       response.setContentType("image/jpg");
       OutputStream output = response.getOutputStream();
       BufferedImage bi = mandelbrotSet.renderMandelbrotSet();
       ImageIO.write(bi,"jpeg", output );
    }

    @GetMapping("/mds/{min_x}/{max_x}/{min_y}/{max_y}")
    public void renderMandelbrotSet(HttpServletResponse response,@PathVariable ("min_x") int min_x,@PathVariable ("max_x") int max_x,
                                    @PathVariable ("min_y") int min_y,@PathVariable ("max_y") int max_y) throws IOException {
        response.setContentType("image/jpg");
        OutputStream output = response.getOutputStream();
        BufferedImage bi = mandelbrotSet.renderMandelbrotSetFromInput(min_x, max_x, min_y, max_y);
        ImageIO.write(bi,"jpeg", output );
    }

   @GetMapping("/index")
        public String home(){
       return "index";
        }

}

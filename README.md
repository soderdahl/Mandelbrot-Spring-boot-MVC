# Mandelbrot-Spring-boot-MVC

Mandelbrot set-calculate part
Inspiration by https://www.youtube.com/watch?v=TDZNsbbdrKM
Modified to my own version
Applications build by Spring boot MVC
Server- content two methods renderMandelbrotSetByDefaultInput() and renderMandelbrotSetFromInput()
API-RestController two get methods to render mandelSet image by default and from input.
Client- WebController, a post method to send x,y values for rendering Mandelbrot image  
Thymeleaf-front-end - static. index.html, render image by hard coding
		         - template.dimension.html,  render image from input

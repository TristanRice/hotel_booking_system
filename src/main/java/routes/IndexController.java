package routes;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;

@Path
public class IndexController {
	
	@GetRoute("/")
	public String index( ) {
		return "index.html";
	}
	
}
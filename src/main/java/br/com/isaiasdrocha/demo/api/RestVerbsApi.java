package br.com.isaiasdrocha.demo.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.isaiasdrocha.demo.domain.MessageResponse;
import br.com.isaiasdrocha.demo.domain.SuccessResponse;
import br.com.isaiasdrocha.demo.enums.EnumParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "{version}")
@RequestMapping(path = {"/api"}, produces = {MediaType.APPLICATION_JSON_VALUE})
public interface RestVerbsApi {

	@ApiOperation(value = "Title and object", nickname = "nickname method", notes = "Method objects is ...", response = SuccessResponse.class)
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok.", response = SuccessResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
		@ApiResponse(code = 204, message = "If there are no matching passes, returns HTTP status 204") }
	)
	@GetMapping(value = "/subject/{param1}/subject2/{param2}/subject3/{enumParam3}")
    ResponseEntity<?> methdNameOne(
    		@PathVariable Integer param1, 
    		@PathVariable String param2,
    	    @PathVariable EnumParam enumParam3, 
    	    @RequestParam(value = "param4", required = false) String param4);
	
	@ApiOperation(value = "Title and object", nickname = "nickname method", notes = "Method objects is ...", response = SuccessResponse.class)
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok.", response = SuccessResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
		@ApiResponse(code = 204, message = "If there are no matching passes, returns HTTP status 204") }
	)
	@RequestMapping(value = "/item/{param1}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	ResponseEntity<?> methodName(
	@ApiParam(value = "Param 1",required=true) @PathVariable("param1") String param1);

	@ApiOperation(value = "Title and object", nickname = "nickname method", notes = "Method objects is ...", response = SuccessResponse.class)
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok.", response = SuccessResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
		@ApiResponse(code = 204, message = "If there are no matching passes, returns HTTP status 204") }
	)
	@RequestMapping(value = "/methodPost/subject", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> methdPost(
    	    @RequestParam(value = "param1", required = true) String param1);
	
	@ApiOperation(value = "Title and object", nickname = "nickname method", notes = "Method objects is ...", response = SuccessResponse.class)
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok.", response = SuccessResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
		@ApiResponse(code = 204, message = "If there are no matching passes, returns HTTP status 204") }
	)
	@RequestMapping(value = "/methodDelete/subject", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> methDelete(
    	    @RequestParam(value = "param1", required = true) String param1);
	
	@ApiOperation(value = "Title and object", nickname = "nickname method", notes = "Method objects is ...", response = SuccessResponse.class)
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok.", response = SuccessResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = MessageResponse.class),
		@ApiResponse(code = 204, message = "If there are no matching passes, returns HTTP status 204") }
	)
	@RequestMapping(value = "/methodPut/subject", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> methPut(
    	    @RequestParam(value = "param1", required = true) String param1);
	
}
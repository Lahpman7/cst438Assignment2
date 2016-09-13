package edu.csumb.cst438fa16qa.rest;

import edu.csumb.cst438fa16.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("")
public class QuestionsAnswersResource{
  public static QuestionsAnswers plug = new QuestionsAnswers();
  @GET
  @Path("/randomquestion")
  public String randomquestion(){
	  //QuestionsAnswers plug = new QuestionsAnswers();
	  plug.put("How many states in the USA?","50");
	  plug.put("How tired am I?", "Very");
	  plug.put("What is the name of our school?","CSUMB");
	  
    return plug.getRandomQuestion();
  }
  
  @GET
  @Path("/testanswer")
  public Response testanswer(
		  @QueryParam("userAnswer") String userAnswer,
		  @QueryParam("oldQuestion") String oldQuestion
		  ){
	  if(userAnswer==null || oldQuestion ==null){
		  return Response.status(Response.Status.BAD_REQUEST)
				  .entity("Requires query parametres!").build();
	  }
	  if(plug.testAnswer(userAnswer, oldQuestion)){
		  return Response.ok("Correct!").build();
	  }
	  return Response.ok("False!").build();
	  
  }
  
}

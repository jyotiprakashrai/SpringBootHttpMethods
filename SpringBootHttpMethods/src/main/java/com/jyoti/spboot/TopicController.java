package com.jyoti.spboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {

		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {

		return topicService.getTopic(id);
	}

	/*
	 * To test this using Postman in Body put 
	 * { "id": "css", "name": "CSS 3", "description": "CSS 3 description" }
	 * In headers put Content-Type = application/json
	 * http://localhost:8080/topics(method change to POST) 
	 * after that
	 * http://localhost:8080/topics(method change to GET)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);

	}

	/*
	 * To test this using Postman in Body put 
	 * { "id": "javaScript", "name": "updated JavaScript", "description": "updated JavaScript description" }
	 * In headers put Content-Type = application/json
	 * http://localhost:8080/topics/javaScript(method change to PUT) 
	 * after that
	 * http://localhost:8080/topics(method change to GET)
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(id, topic);

	}
	/* To test
	http://localhost:8080/topics(Make GET request)
	http://localhost:8080/topics/Java(Make DELETE request)
		Again make
	http://localhost:8080/topics(Make GET request)
	*/
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {

		topicService.deleteTopic(id);
	}

}

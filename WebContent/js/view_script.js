/**
 * view_script.js - for loading a specific image
 */

// Script proper
$(document).ready(function() {
	// Scan URL for image
	var query = location.search;
	var id = decode(query);
	
	// Fill in info details
	$("#uploader").html("Uploaded by <a href = \"/Fakebook/jsp/profile.jsp?user=" + id + "\">"
					+ ((id == 1) ? "A public uploader" : "A private uploader") + "</a>");
	$("#title").html((id == 1) ? "A public picture" : "A private picture");
	$("#img").append("<img src = \"/Fakebook/img/content/" + ((id == 1) ? "public.png" : "res.png") + "\" />");
	
	// Handler for go back button
	$("#go-back").click(function () {
		history.go(-1);
	});
});

function decode(query) {
	var id = query.split("=")[1];
	
	return id;
}


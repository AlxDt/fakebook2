/**
 * profile_script.js - for loading a profile page's images
 */

// Public photos displayed
var numPublicPhotos = 20;

// Last public photos displayed
var lastPublicPhotos = 0;

// Shared photos displayed
var numSharedPhotos = 20;

// Last shared photos displayed
var lastSharedPhotos = 0;

// Photos per grid
var rowNum = 10;

$(document).ready(

		function() {

			// Generate public photos
			lastPublicPhotos = generatePublicPhotos(numPublicPhotos,
					lastPublicPhotos, rowNum);
		});

function onClickPublic() {
	lastPublicPhotos = generatePublicPhotos(numPublicPhotos, lastPublicPhotos,
			rowNum);
}

function onClickShared() {
	lastSharedPhotos = generateSharedPhotos(numSharedPhotos, lastSharedPhotos,
			rowNum);
}

function generatePublicPhotos(numPhotos, lastPhotos, rowNum) {
	var i = lastPhotos;
	var j = 0;

	/*
	 * if (i >= photos.length) { alert("No more public photos!"); }
	 */

	for (; j < numPhotos /* && i < photos.length */; i++) {
		/*
		 * if (i % rowNum == 0) { $("#public-grid").append("<tr id = \"row-" + Math.floor(i / rowNum) + "\"></tr>\n"); }
		 * 
		 * $("#row-" + Math.floor(i / rowNum)).append("<td><a href =
		 * \"url_img.html\"><img src = \"../img/content/public.png\" alt =
		 * \"o\" height=\"100\" width=\"100\"/></a></td>\n");
		 * 
		 * j++;
		 */
		$("#public-grid")
				.append(
						"<div class = \"img\"><a href = \"/Fakebook/img?img=1\"><img src = \"/Fakebook/img/content/public.png\" alt = \"o\" height=\"100\" width=\"100\"/></a></div>");

		j++;
	}

	return i;
}

function generateSharedPhotos(numPhotos, lastPhotos, rowNum) {
	var i = lastPhotos;
	var j = 0;

	/*
	 * if (i >= photos.length) { alert("No more public photos!"); }
	 */

	for (; j < numPhotos /* && i < photos.length */; i++) {
		/*
		 * if (i % rowNum == 0) { $("#public-grid").append("<tr id = \"row-" + Math.floor(i / rowNum) + "\"></tr>\n"); }
		 * 
		 * $("#row-" + Math.floor(i / rowNum)).append("<td><a href =
		 * \"url_img.html\"><img src = \"../img/content/public.png\" alt =
		 * \"o\" height=\"100\" width=\"100\"/></a></td>\n");
		 * 
		 * j++;
		 */
		$("#shared-grid")
				.append(
						"<div class = \"img\"><a href = \"/Fakebook/img?img=0\"><img src = \"/Fakebook/img/content/res.png\" alt = \"o\" height=\"100\" width=\"100\"/></a></div>");

		j++;
	}

	return i;
}

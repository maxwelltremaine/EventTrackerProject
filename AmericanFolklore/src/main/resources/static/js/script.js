console.log('script.js loaded');

window.addEventListener('load', function(event) {
	console.log('Page loaded, DOM complete');
	init();
});


function init() {
	document.folkloreForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		let folkloreId = document.folkloreForm.folkloreId.value;
		if (!isNaN(folkloreId) && folkloreId > 0) {
			console.log('Folklore Id:' + folkloreId);
			getFolkloreDetails(folkloreId);
		}
	});
	//set up event handlers, load intial data, etc
	loadAmericanFolklore();



	newFolkloreForm.addFolkloreButton.addEventListener('click', function(evt) {
		let form = document.newFolkloreForm;
		evt.preventDefault();
		let newFolklore = {
			name: form.name.value,
			category: form.category.value,
			description: form.description.value,
			lore: form.lore.value,
			loreUrl: form.loreUrl.value,
			state: form.state.value,
			city: form.city.value,
			street: form.street.value
		};


		console.log(newFolklore);
		addFolklore(newFolklore);


	});
}


function loadAmericanFolklore() {

	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/folklore');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let folklore = JSON.parse(xhr.responseText);
				console.log(folklore);
				displayFolklore(folklore);
			}
		}
	};

	xhr.send();

}


function deleteFolklore(folkloreId) {

	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', `api/folklore/${folkloreId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let folklore = JSON.parse(xhr.responseText);
				console.log(folklore);
				displayFolklore(folklore);

			}
		}
	};

	xhr.send();

}

function displayFolklore(folklore) {
	console.log(folklore);
	let tbody = document.getElementById('folkloreBody');
	for (let singleFolklore of folklore) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		let td = document.createElement('td');
		td.textContent = singleFolklore.id;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = singleFolklore.name;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = singleFolklore.category;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = singleFolklore.description;
		tr.appendChild(td);



		tr.addEventListener('click', function(event) {
			console.log(event.target);
			let folkloreId = event.target.parentElement.firstElementChild.textContent;
			getFolkloreDetails(folkloreId);

		});
	}
}

function getFolkloreDetails(folkloreId) {
	console.log('getting details for folklore ' + folkloreId);

	let xhr = new XMLHttpRequest();
	xhr.open('GET', `api/folklore/${folkloreId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let folklore = JSON.parse(xhr.responseText);
				console.log(folklore);
				displaySingleFolklore(folklore);
			}
		}
	};

	xhr.send();
	//TODO XHR call to get mapping for single folklore
}


function displaySingleFolklore(folklore) {
	let dataDiv = document.getElementById("folkloreDiv");
	dataDiv.textContent = '';
	let name = document.createElement('h1');
	name.textContent = folklore.name;
	let category = document.createElement('li');
	category.textContent = "Category " + folklore.category;
	let description = document.createElement('blockquote');
	description.textContent = "Description: " + folklore.description;
	let lore = document.createElement('blockquote');
	lore.textContent = "Folklore: " + folklore.lore;
	let loreUrl = document.createElement('li');
	loreUrl.textContent = "Lore Link: " + folklore.loreUrl;
	let state = document.createElement('li');
	state.textContent = "State: " + folklore.state;
	let city = document.createElement('li');
	city.textContent = "City: " + folklore.city;
	let street = document.createElement('li');
	street.textContent = "Street: " + folklore.street;
	dataDiv.appendChild(name);
	dataDiv.appendChild(category);
	dataDiv.appendChild(description);
	dataDiv.appendChild(lore);
	dataDiv.appendChild(loreUrl);
	dataDiv.appendChild(state);
	dataDiv.appendChild(city);
	dataDiv.appendChild(street);


	
	let folkloreId = document.createElement("input");
	folkloreId.setAttribute("type", "hidden");
	folkloreId.setAttribute("name", "folkloreId");
	folkloreId.setAttribute("value", `${folklore.id}`);
	deleteForm.appendChild(folkloreId);
	let submitBtn = document.createElement("input");
	submitBtn.setAttribute("type", "submit");
	deleteForm.appendChild(submitBtn);

}
function deleteForm() {
	let deleter = document.createElement('form');
	deleter.setAttribute('method', 'delete');

}


function addFolklore(folklore) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/folklore');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 201) {
				let createdFolklore = JSON.parse(xhr.responseText);
				displaySingleFolklore(createdFolklore);
			}
			else {
				displayError('Error creating Folklore: ' + xhr.status);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json')
	xhr.send(JSON.stringify(folklore));
	window.location.reload();
}

function updateFolklore(folkloreId) {
	let folkloreToUpdate = getFolkloreDetails(folkloreId);
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `api/folklore/${folkloreId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 201) {
				let updatedFolklore = JSON.parse(xhr.responseText);
				displaySingleFolklore(updatedFolklore);
			}
			else {
				displayError('Error creating Folklore: ' + xhr.status);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json')
	xhr.send(JSON.stringify(folklore));
	window.location.reload();
}





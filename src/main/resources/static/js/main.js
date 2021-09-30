function blogPost() {
    const name = document.getElementById("nameI").value;
    const title = document.getElementById("titleI").value;
    const content = document.getElementById("contentI").value;
    const data = {
        name: name,
        title: title,
        content: content
    };
    axios.post("/create", data).then(function (response) {
        console.log(response);
    })
    console.log(name, title, content)
}


function getList() {
    let out = "";
    axios.get("/list")
        .then(function (response) {
            if (response.status === 200) {
                const outString = JSON.stringify(response.data);
                const data = JSON.parse(outString);
                data.forEach(function (d) {
                    out += `<div class="card col-sm-4">
                              <div class="card-body">
                              <span>${d.id}</span>
                                <h5 class="card-title">${d.title}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">${d.name}</h6>
                                <p class="card-text">${d.content}</p>
                                <form><button class="btn btn-danger" onclick="deleteApp(${d.id})">Delete</button></form>
                              </div>
                            </div>`
                });
                document.getElementById("list").innerHTML = out;
            }
        })
}

function deleteApp(id) {
    console.log(id);
    axios.delete("delete", {params: {id: id}})
}
let menuBTN = document.getElementById("menuBTN")
let bodyTAG = document.querySelector("body")
let screens = document.getElementsByClassName("screen")

let createSupplierBTN = document.getElementById("createSupplierBTN")
let createSupplier = document.getElementById("createSupplier")
let viewSupplier = document.getElementById("viewSupplier")
let viewSupplierBTN = document.getElementById("viewSupplierBTN")
let addSupplierBTN = document.getElementById("addSupplierBTN")




menuBTN.addEventListener("click", () => {
    bodyTAG.classList.toggle("active")
    menuBTN.classList.toggle("fa-xmark")
})

createSupplierBTN?.addEventListener("click", (e) => {
    for (let i = 0; i < screens.length; i++) {
        screens[i].classList.add("d-none")
    }
    createSupplier.classList.remove("d-none")
})

viewSupplierBTN?.addEventListener("click", (e) => {
    for (let i = 0; i < screens.length; i++) {
        screens[i].classList.add("d-none")
    }
    viewSupplier.classList.remove("d-none")
    updateTable()
})


////////////////////////////////////

function updateTable(){
    var url = "http://localhost:9090/supplier/getAll"
    $("#supplierTable tbody").empty()
    $.ajax({
        url:url,
        type:"GET",
        datatype:"json",
        success:function(data){
            for(i=0; i<data.length; i++){
                $("#supplierTable tbody").append("<tr><td>" + data[i].id
                    + "</td><td>" + data[i].name
                    + "</td><td>" + data[i].email
                    + "</td><td>" + data[i].phone
                    + "</td><td>" + "<button class='btn btn-success'>Delete</button>"
                    + "</td></tr>")
            }
            console.log(data)
        },
        error:function(){
            console.log("error")
        }
    });
}

addSupplierBTN?.addEventListener("click", (e) => {
    addSupplier()
})

function addSupplier(){
    var addressData = {
        apartmentNumber: $("#apartmentNumber").val(),
        street: $("#street").val(),
        city: $("#city").val(),
        country: $("#country").val(),
    };
    var url = "http://localhost:9090/address/add"
    var address
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: url,
        data: JSON.stringify(addressData),
        dataType: "json",
        success: function(response) {
            var formData = {
                birthdate: $("#SupplierBirthdate").val(),
                name: $("#SupplierName").val(),
                phone: $("#SupplierPhone").val(),
                address: {
                    id: response.id,
                },
                email: $("#SupplierEmail").val(),
                password: $("#SupplierPassword").val()
            };

            var url = "http://localhost:9090/supplier/add"
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: url,
                data: JSON.stringify(formData),
                dataType: "json",
                success: function(response) {
                    alert("Supplier added successfully!");
                    console.log(response);
                },
                error: function(error) {
                    console.log("Error submitting form: " + error);
                }
            });
        },
        error: function(error) {
            console.log("Error submitting form: " + error);
        }
    });


}



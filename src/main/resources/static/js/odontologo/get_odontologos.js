window.addEventListener('load', function () {

    (function(){

      const url ='http://localhost:8080/odontologos';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(function(response){
            return response.json();
    } )
    .then(data => {


         for(odontologo of data){

          let table = document.querySelector("#odontologos");
          let dentistRow =table.insertRow();
          let tr_id = 'tr_' + odontologo.id;
          dentistRow.id = tr_id;

           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +

                                      ' type="button" onclick="deleteById('+odontologo.id+')" class="danger">' +
                                     // '&times' +
                                      ' <i class="fa-solid fa-trash-can icon-left"></i>'+
                                      '</button>';

                    let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findById('+odontologo.id+')" class="info btn_id">' +
                                      odontologo.id +
                                      '</button>';


          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del pacientes
          //como ultima columna el boton eliminar
         dentistRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_name\">' + odontologo.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_surname\">' + odontologo.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_surname\">' + odontologo.numeroMatricula+ '</td>' +
                              '<td>' + deleteButton + '</td>';

        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "odontologos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})
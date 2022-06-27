window.addEventListener('load', function () {

    (function(){

      const url ='http://localhost:8080/pacientes';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(function(response){
            return response.json();
    } )
    .then(data => {


         for(paciente of data){

          let table = document.querySelector("#pacientes");
          let dentistRow =table.insertRow();
          let tr_id = 'tr_' + paciente.id;
          dentistRow.id = tr_id;

           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteById('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

                    let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findById('+paciente.id+')" class="btn btn-info btn_id">' +
                                      paciente.id +
                                      '</button>';


          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del pacientes
          //como ultima columna el boton eliminar
         dentistRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_name\">' + paciente.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_surname\">' + paciente.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_surname\">' + paciente.dni+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.dni+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.dni+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.dni+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.dni+ '</td>' +
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
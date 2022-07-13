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
          let pacienteRow =table.insertRow();
          let tr_id = 'tr_' + paciente.id;
          pacienteRow.id = tr_id;

           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteById('+paciente.id+')" class="danger btn_delete">' +

                                      ' <i class="fa-solid fa-trash-can icon-left"></i>'+
                                      '</button>';

                    let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findById('+paciente.id+')" class="info btn_id">' +
                                      paciente.id +
                                      '</button>';


          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del pacientes
          //como ultima columna el boton eliminar
         pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_name\">' + paciente.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_surname\">' + paciente.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_surname\">' + paciente.dni+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.domicilio.calle.toUpperCase()+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.domicilio.numero+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.domicilio.ciudad.toUpperCase()+ '</td>' +
                              '<td class=\"td_surname\">' + paciente.domicilio.provincia.toUpperCase()+ '</td>' +
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
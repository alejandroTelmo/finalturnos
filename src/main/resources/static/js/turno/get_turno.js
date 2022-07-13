window.addEventListener('load',function(){

    const tablaTurnos=document.querySelector('#turnos');
    const url='http://localhost:8080/turnos';
    const settings={
    method:'GET'
    }
    fetch(url,settings)
    .then(response=>response.json())
    .then(data=>{

        for(turno of data){

               let table = document.querySelector("#turnos");
                      let turnoRow =table.insertRow();
                      let tr_id = 'tr_' + turno.id;
                      turnoRow.id = tr_id;

      let deleteButton = '<button' +
     ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
      ' type="button" onclick="deleteById('+turno.id+')" class="danger ">' +
                                                           ' <i class="fa-solid fa-trash-can icon-left"></i>'+
                                                           '</button>';

        let updateButton = '<button' +
          ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
          ' type="button" onclick="findById('+turno.id+')" class="info">' +
            turno.id +
             '</button>';

 //let fecha=new Date(turno.diaturno).toLocaleDateString('es-AR').toString();
//console.log( turno.paciente.nombre.toUpperCase() )
//console.log(fecha)
   turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_name\">' + turno.paciente.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_name\">' + turno.paciente.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_name\">' + turno.odontologo.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_name\">' + turno.odontologo.apellido.toUpperCase() + '</td>' +

                              '<td class=\"td_name\">' + turno.diaturno+ '</td>' +



                              '<td class=\"td_name\">' + turno.horaturno + '</td>' +

                              '<td>' + deleteButton + '</td>';

        }
    })

})
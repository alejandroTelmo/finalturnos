window.addEventListener('load',function(){

    const tablaUsuarios=document.querySelector('#usuarios');
    const url='http://localhost:8080/usuarios';
    const settings={
    method:'GET'
    }
    fetch(url,settings)
    .then(response=>response.json())
    .then(data=>{

        for(usuario of data){

               let table = document.querySelector("#usuarios");
                      let usuarioRow =table.insertRow();
                      let tr_id = 'tr_' + usuario.id;
                      usuarioRow.id = tr_id;

      let deleteButton = '<button' +
     ' id=' + '\"' + 'btn_delete_' + usuario.id + '\"' +
      ' type="button" onclick="deleteById('+usuario.id+')" class="btn btn-danger btn_delete">' +
                                                           '&times' +'</button>';

        let updateButton = '<button' +
          ' id=' + '\"' + 'btn_id_' + usuario.id + '\"' +
          ' type="button" onclick="findById('+usuario.id+')" class="btn btn-info btn_id">' +
            usuario.id +
             '</button>';

   usuarioRow.innerHTML = '<td>' + updateButton + '</td>' +

                              '<td class=\"td_name\">' + usuario.username.toUpperCase() + '</td>' +
                              '<td>' + deleteButton + '</td>';

        }
    })

})
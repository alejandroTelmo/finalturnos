window.addEventListener('load',function(){

    const formAlta=document.querySelector('#formularioAlta');

    formAlta.addEventListener('submit',function(e){
        e.preventDefault();
        const url='http://localhost:8080/usuarios';
        if(document.querySelector('#password').value===document.querySelector('#repeatPassword').value){
                const data={
                      username:document.querySelector('#username').value,
                      password:document.querySelector('#password').value
                      }
                const settings={
                    method:'POST',
                    headers:{
                    'Content-Type':'application/json'
                    },
                    body:JSON.stringify(data)
                }
                fetch(url,settings)
                .then(response=>response.json())
                .then(data=>{
                console.log(data)
                alert("Usuario guardado con exito")
                resetForm();
               } )

        }else{
        alert("Los password ingresados no coinciden, ingreselos nuevamente.");
        resetForm();
        }

    })

})
function resetForm(){
                        document.querySelector('#username').value="",
                      document.querySelector('#password').value="",
                      document.querySelector('#repeatPassword').value=""
                      lista();
                }
         (function lista(){
                          const crear=document.querySelector("#altaUsuario")
                          crear.addEventListener('click',()=>{
                              window.location.assign("usuario_lista.html")
                          })

                       } )();
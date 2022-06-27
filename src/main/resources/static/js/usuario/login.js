window.addEventListener('load',function(){
    const formLogin=document.querySelector('#login');
    formLogin.addEventListener('submit',function(e){
    e.preventDefault();
    const url='http://localhost:8080/usuarios'
    const formData={
        username:document.querySelector('#username').value,
        password:document.querySelector('#password').value
    }
    const settings={
        method:'GET'
    }
    fetch(url,settings)
    .then(response=>response.json())
    .then(data=>{

    })
    })

})
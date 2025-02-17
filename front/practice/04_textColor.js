window.onload = ()=>{
    const title = document.querySelector('#heading');
    
    title.onclick = ()=>{
        if(title.style.color=='red'){
            title.style.color='black'
        }else{
            title.style.color='red';
        }
    }
}
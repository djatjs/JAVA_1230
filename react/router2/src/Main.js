function Main(){
    fetch("/api/test")
    .then(res=>res.text())
    .then(data=>console.log(data));
    return(
        <div>
            <h1>메인</h1>
        </div>
    );
}
export default Main;
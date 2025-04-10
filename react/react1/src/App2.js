import { useState } from "react";

function App2(){
    let [hobby, setHobby] = useState("");
    //e=>setHobby(e.target.value)
    function change(e){
        let {value, name, checked} = e.target;
        setHobby(value);
    }
    return(
        <div>
            <label>
                <input onClick={change} type="radio" name="hobby" value={"독서"}/>독서
            </label>
            <label>
                <input onClick={change} type="radio" name="hobby" value={"운동"}/>운동
            </label>
            <label>
                <input onClick={change} type="radio" name="hobby" value={"음악감상"}/>음악감상
            </label>
            <h1>{hobby}</h1>
        </div>
    );
}
export default App2;
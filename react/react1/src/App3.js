import { useState } from "react";

function App3(){
    let [hobbies, setHobbies] = useState([]);

    function change(e){
        let {value, checked} = e.target;
        //check된 상태이면 배열에 추가
        if(checked){
            setHobbies([...hobbies, value]);
        }
        //아니면 배열에서 제거
        else{
            //setHobbys(hobbys.filter(v=>v !== value))
            let index = hobbies.indexOf(value);
            let tmp = [...hobbies];
            tmp.splice(index, 1);
            setHobbies(tmp);
        }
    }
    return(
        <div>
            <label>
                <input onClick={change} type="checkbox" name="hobby" value={"독서"}/>독서
            </label>
            <label>
                <input onClick={change} type="checkbox" name="hobby" value={"운동"}/>운동
            </label>
            <label>
                <input onClick={change} type="checkbox" name="hobby" value={"음악감상"}/>음악감상
            </label>
            <h1>{hobbies.join(",")}</h1>
        </div>
    );
}
export default App3;
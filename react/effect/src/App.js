import { useEffect, useState } from "react";

function App() {
  let[num, setNum] = useState(0);
  let[num2, setNum2] = useState(0);
  //랜더링이 실행될 때마다 다시 실행됨
  console.log("App 실행")
  
  //배열과 함께 콜백함수가 필요함
  useEffect(()=>{
    console.log("처음 랜더링할 때만 실행");
    //[]이면 처음 랜더링될 때만 실행
  },[])
  useEffect(()=>{
    console.log("num이 바뀔 때만 실행");
    //[num]이면 num이 바뀌고 랜더링될 때만 실행
  },[num])
  return (
    <div>
      <button onClick={(e)=>setNum(++num)}>+</button>
      <div>{num}</div>
      <button onClick={(e)=>setNum2(++num2)}>+</button>
      <div>{num2}</div>
    </div>
  );
}

export default App;

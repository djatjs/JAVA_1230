import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Signup(){
    const navigate = useNavigate();

    let [data, setData] = useState({
        me_id : '',
        me_pw : '',
        me_pw2 : '',
        me_email : ''
    });

    const chechRegex = e =>{
         //유효성 검사
         if(data.me_id ===''){
            alert("아이디는 필수항목입니다.")
            return false;
        }
        if(data.me_pw === ''){
            alert("비밀번호는 필수항목입니다.")
            return false;
        }
        if(data.me_pw !== data.me_pw2){
            alert("비밀번호가 일치하지 않습니다.")
            return false;
        }
        if(data.me_email === ''){
            alert("이메일은 필수항목입니다.")
            return false;
        }
        return true;
    }

    const clearData = e =>{
        setData({
            me_id : '',
            me_pw : '',
            me_pw2 : '',
            me_email : ''
        })
    }

    const submit = function(e){
        e.preventDefault();
        if(!chechRegex()){
            return;
        }
        fetch("/api/react/signup",{
            method : "post",
            body : JSON.stringify(data),
            headers : {
                "Content-type" : "application/json"
            }
        })
        .then(res=>res.json())
        .then(res=>{
            console.log(res);
            if(res){
                //alert("회원가입 완료");
                //메인 페이지로 이동
                navigate('/',{
                    state :{res : res}
                }); 
            }
            else{
                alert("회원가입 실패");
                clearData();
            }
        })
       
    }

    const change = e =>{
        setData({
            ...data,
            [e.target.name] : e.target.value
        })
        console.log(data)
    }

    return(
        <div className="container">
            <h1>회원 가입</h1>
            <form onSubmit={submit}>
                <div className="mb-3 mt-3">
                    <label htmlFor="id" className="form-label">아이디</label>
                    <input onChange={change} type="text" className="form-control" id="id" placeholder="아이디를 입력하세요" name="me_id" value={data.me_id}/>
                </div>
                <div className="mb-3 mt-3">
                    <label htmlFor="pw" className="form-label">비밀번호</label>
                    <input onChange={change} type="password" className="form-control" id="pw" placeholder="비밀번호를 입력하세요" name="me_pw" value={data.me_pw}/>
                </div>
                <div className="mb-3 mt-3">
                    <label htmlFor="pw2" className="form-label">비밀번호 확인</label>
                    <input onChange={change} type="password" className="form-control" id="pw2" placeholder="비밀번호 확인" name="me_pw2" value={data.me_pw2}/>
                </div>
                <div className="mb-3 mt-3">
                    <label htmlFor="email" className="form-label">이메일</label>
                    <input onChange={change} type="email" className="form-control" id="email" placeholder="이메일을 입력하세요" name="me_email" value={data.me_email}/>
                </div>
                <button className="btn btn-outline-success col-12">회원가입</button>
            </form>
        </div>
    );
}
export default Signup;
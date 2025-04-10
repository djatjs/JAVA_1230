import {BrowserRouter, Link, Route, Routes} from 'react-router-dom'
import Main from './Main';
import PostList from './PostList';
import PostInsert from './PostInsert';
import Nav from './Nav';
import PostDetail from './PostDetail';

function App() {
  

  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route path='/' exact element={<Main/>} />
        <Route path='/post/list/:num' element={<PostList/>} />
        {/* <Route path='/post/insert' element={<PostInsert/>} /> */}
        <Route path='/post/detail/:num' exact element={<PostDetail/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
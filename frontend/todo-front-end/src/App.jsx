import { BrowserRouter, Route, Routes } from 'react-router-dom'
import TodoListComponent from "./Components/TodoListComponent"
import AddToDoComponent from "./Components/AddToDoComponent"
import Header from "./UtilityComponents/Header"

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path='/' element={<TodoListComponent />} />
        <Route path='/add-todo' element={<AddToDoComponent />} />
        <Route path='/update-todo/:id' element={<AddToDoComponent />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App

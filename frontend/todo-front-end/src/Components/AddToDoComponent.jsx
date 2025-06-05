import React, { useEffect, useState } from 'react'
import { addToDo } from '../CrudServices/AddTodoService';
import { useNavigate, useParams } from 'react-router-dom';
import { getById } from '../CrudServices/GetByIdService';
import { updateTodo } from '../CrudServices/UpdateTaskService';

function AddToDoComponent() {
    const navigate = useNavigate()
    const { id } = useParams();

    const [todoTitle, setTodoTitle] = useState('');
    const [todoDescription, setTodoDescription] = useState('');
    const [complete, setComplete] = useState(false);
    const [errors, setErrors] = useState({ todoTitle: '', todoDescription: '' });

    useEffect(() => {
        if (id) {
            getById(id).then((response) => {
                const task = response.data;
                setTodoTitle(task.todoTitle);
                setTodoDescription(task.todoDescription);
                setComplete(task.todoComplete);
            }).catch(error => {
                console.error(error);
            });
        }
    }, [id]);

    const handleToDoTitle = (e) => setTodoTitle(e.target.value);
    const handleToDoDescription = (e) => setTodoDescription(e.target.value);
    const handleIsComplete = (e) => setComplete(e.target.checked);

    const validateForm = () => {
        let valid = true;
        const errorsCopy = { todoTitle: '', todoDescription: '' };

        if (!todoTitle.trim()) {
            errorsCopy.todoTitle = 'Todo title is required';
            valid = false;
        }

        if (!todoDescription.trim()) {
            errorsCopy.todoDescription = 'Todo description is required';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    const saveToDo = (e) => {
        e.preventDefault();
        if (!validateForm()) return;

        const todo = { todoTitle, todoDescription, todoComplete: complete };

        if (id) {
            updateTodo(id, todo)
                .then(() => navigate('/'))
                .catch(err => console.log(err));
        } else {
            addToDo(todo)
                .then(() => navigate('/'))
                .catch(err => console.log(err));
        }
    }


    return (
        <div className="container">
            <div className="text-center">
                <h2>{id ? 'Update Todo' : 'Add Todo'}</h2>
            </div>
            <form onSubmit={saveToDo}>
                <div className="form-group mb-3">
                    <label htmlFor="todo-title">Todo Title</label>
                    <input
                        type="text"
                        value={todoTitle}
                        className={`form-control ${errors.todoTitle ? 'is-invalid' : ''}`}
                        id="todo-title"
                        placeholder="Enter to-do title"
                        onChange={handleToDoTitle}
                    />
                    {errors.todoTitle && <div className='invalid-feedback'>{errors.todoTitle}</div>}
                </div>

                <div className="form-group mb-3">
                    <label htmlFor="todo-description">Todo Description</label>
                    <input
                        type="text"
                        value={todoDescription}
                        className={`form-control ${errors.todoDescription ? 'is-invalid' : ''}`}
                        id="todo-description"
                        placeholder="Enter to-do description"
                        onChange={handleToDoDescription}
                    />
                    {errors.todoDescription && <div className='invalid-feedback'>{errors.todoDescription}</div>}
                </div>

                <div className="form-group mb-3 form-check">
                    <input
                        type="checkbox"
                        checked={complete}
                        className="form-check-input"
                        id="todo-complete"
                        onChange={handleIsComplete}
                    />
                    <label className="form-check-label" htmlFor="todo-complete">Completed</label>
                </div>

                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    );
}

export default AddToDoComponent

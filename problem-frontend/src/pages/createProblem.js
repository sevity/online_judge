import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css'

export default function CreateProblem() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [exampleInput, setExampleInput] = useState("");
    const [exampleOutput, setExampleOutput] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        // 서버에 데이터를 전송하는 코드를 여기에 작성합니다.
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col">
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="title" className="form-label">제목</label>
                            <input type="text" className="form-control" id="title" value={title} onChange={(e) => setTitle(e.target.value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="description" className="form-label">설명</label>
                            <textarea className="form-control" id="description" rows="10" value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInput" className="form-label">예제 입력</label>
                            <textarea className="form-control" id="exampleInput" rows="3" value={exampleInput} onChange={(e) => setExampleInput(e.target.value)}></textarea>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleOutput" className="form-label">예제 출력</label>
                            <textarea className="form-control" id="exampleOutput" rows="3" value={exampleOutput} onChange={(e) => setExampleOutput(e.target.value)}></textarea>
                        </div>
                        <button type="submit" className="btn btn-primary">제출</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

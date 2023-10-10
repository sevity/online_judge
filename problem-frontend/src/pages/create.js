import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

export default function CreateProblem() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [exampleInput, setExampleInput] = useState("");
    const [exampleOutput, setExampleOutput] = useState("");
    const [realInput, setRealInput] = useState("");
    const [realOutput, setRealOutput] = useState("");
    const [successMessage, setSuccessMessage] = useState(null);
    const [submittedProblem, setSubmittedProblem] = useState(null);

    const handleSubmit = async (event) => {
        event.preventDefault();

        const data = {
            title,
            description,
            exampleInput,
            exampleOutput,
            realInput,
            realOutput
        };

        try {
            const response = await fetch('https://sevity.com:9993/problems', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                // 서버로의 전송 성공 시에 실행할 로직을 작성합니다.
                console.log('데이터 전송 성공');
                setSuccessMessage('문제가 성공적으로 제출되었습니다.');
                setSubmittedProblem(data);
            } else {
                // 서버로의 전송 실패 시에 실행할 로직을 작성합니다.
                console.error('데이터 전송 실패');
            }
        } catch (error) {
            console.error('데이터 전송 중 오류 발생:', error);
        }
    };

    return (
        <div className="container">
            {successMessage && <div className="alert alert-success mt-3">{successMessage}</div>}
            {submittedProblem && (
                <div className="mt-3">
                    <h3>{submittedProblem.title}</h3>
                    <p>{submittedProblem.description}</p>
                    <p>예제 입력: {submittedProblem.exampleInput}</p>
                    <p>예제 출력: {submittedProblem.exampleOutput}</p>
                    <p>채점용 입력: {submittedProblem.realInput}</p>
                    <p>채점용 출력: {submittedProblem.realOutput}</p>
                </div>
            )}
            {!successMessage && (
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
                        <div className="mb-3">
                            <label htmlFor="realInput" className="form-label">채점용 입력</label>
                            <textarea className="form-control" id="realInput" rows="3" value={realInput} onChange={(e) => setRealInput(e.target.value)}></textarea>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="realOutput" className="form-label">채점용 출력</label>
                            <textarea className="form-control" id="realOutput" rows="3" value={realOutput} onChange={(e) => setRealOutput(e.target.value)}></textarea>
                        </div>
                        <button type="submit" className="btn btn-primary">제출</button>
                    </form>
                </div>
            </div>
            )}
        </div>
    )
}

import React, { useState } from 'react';

const Answer = () => {
  const [answers, setAnswers] = useState([]);
  const [editingId, setEditingId] = useState(null);
  const [editedContent, setEditedContent] = useState('');

  const handleEdit = (answerId, currentContent) => {
    setEditingId(answerId);
    setEditedContent(currentContent);
  };

  const handleSaveEdit = () => {
    if (editedContent.trim() !== '') {
      const updatedAnswers = answers.map((answer) =>
        answer.id === editingId
          ? { ...answer, content: editedContent }
          : answer,
      );
      setAnswers(updatedAnswers);
      setEditingId(null);
      setEditedContent('');
    }
  };

  const handleDelete = (answerId) => {
    const updatedAnswers = answers.filter((answer) => answer.id !== answerId);
    setAnswers(updatedAnswers);
  };

  return (
    <div>
      {answers.map((answer) => (
        <div key={answer.id}>
          {editingId === answer.id ? (
            <div>
              <textarea
                value={editedContent}
                onChange={(e) => setEditedContent(e.target.value)}
              />
              <button onClick={handleSaveEdit}>Save</button>
            </div>
          ) : (
            <div>
              <p>{answer.content}</p>
              <button onClick={() => handleEdit(answer.id, answer.content)}>
                Edit
              </button>
              <button onClick={() => handleDelete(answer.id)}>Delete</button>
            </div>
          )}
        </div>
      ))}
    </div>
  );
};

export default Answer;

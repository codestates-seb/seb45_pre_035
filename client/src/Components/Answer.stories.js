import Answer from './Answer';

// More on how to set up stories at: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'Components/Answer',
  component: Answer,
  parameters: {
    // Optional parameter to center the component in the Canvas. More info: https://storybook.js.org/docs/react/configure/story-layout
    layout: 'centered',
  },
  // This component will have an automatically generated Autodocs entry: https://storybook.js.org/docs/react/writing-docs/autodocs
  tags: ['autodocs'],
  // More on argTypes: https://storybook.js.org/docs/react/api/argtypes
  argTypes: {},
};

// More on writing stories with args: https://storybook.js.org/docs/react/writing-stories/args
export const Primary = {
  args: {
    answers: [
      {
        answerId: 1,
        content:
          '내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내',
        createdAt: '2023-08-01T12:34:56Z',
        author: '홍길동',
        memberId: 2,
        comments: [
          {
            commentId: 2,
            content: '댓글 내용',
            createdAt: '2023-08-01T12:34:56Z',
            author: '박해커',
            memberId: 3,
          },
        ],
        likes_count: 42, // 현재 좋아요 수
        user_has_liked: true, // 현재 사용자가 좋아요를 눌렀는지 여부
      },
      {
        answerId: 2,
        content:
          '내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내용들내',
        createdAt: '2023-08-01T12:34:56Z',
        author: '홍길동',
        memberId: 2,
        comments: [
          {
            commentId: 4,
            content: '댓글 내용',
            createdAt: '2023-08-01T12:34:56Z',
            author: '박해커',
            memberId: 3,
          },
          {
            commentId: 5,
            content: '댓글 내용',
            createdAt: '2023-08-01T12:34:56Z',
            author: '박해커',
            memberId: 3,
          },
        ],
        likes_count: 42, // 현재 좋아요 수
        user_has_liked: true, // 현재 사용자가 좋아요를 눌렀는지 여부
      },
    ],
  },
};

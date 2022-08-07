

CREATE TABLE IF NOT EXISTS quiz (
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(500),
    date    DATE
);

CREATE TABLE IF NOT EXISTS question_answer (
    id          BIGSERIAL PRIMARY KEY,
    question    VARCHAR(1000),
    answer      VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS quiz_question_answer (
    id                  BIGSERIAL PRIMARY KEY,
    quiz_id             BIGINT REFERENCES quiz(id) DEFAULT NULL,
    question_answer_id  BIGINT REFERENCES question_answer(id) DEFAULT NULL,
    selected_answer     VARCHAR(500),
    is_correct          BOOLEAN DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS distractor (
    id                  BIGSERIAL PRIMARY KEY,
    distractor          VARCHAR(500),
    question_answer_id  BIGINT REFERENCES question_answer(id)
);


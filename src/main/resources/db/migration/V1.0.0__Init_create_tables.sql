

CREATE TABLE IF NOT EXISTS quiz (
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(500),
    date                DATE
);

CREATE TABLE IF NOT EXISTS question_answer (
    id          BIGSERIAL PRIMARY KEY,
    question    VARCHAR(1000),
    answer      VARCHAR(500),
    quiz_id     BIGINT REFERENCES quiz(id) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS distractor (
    id                  BIGSERIAL PRIMARY KEY,
    distractor          VARCHAR(500),
    question_answer_id  BIGINT REFERENCES question_answer(id)
);


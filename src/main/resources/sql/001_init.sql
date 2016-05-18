BEGIN TRANSACTION;

DROP TABLE IF EXISTS "spots" CASCADE;
DROP SEQUENCE IF EXISTS "spot_id_seq" CASCADE;

CREATE SEQUENCE "spot_id_seq";

CREATE TABLE "spots" (
    "spot_id"           BIGINT PRIMARY KEY DEFAULT "nextval"('"spot_id_seq"'),
    "imei"              TEXT,
    "spot_timestamp"    TIMESTAMP WITH TIME ZONE DEFAULT "now"(),
    "lat"               DOUBLE PRECISION,
    "lon"               DOUBLE PRECISION,
    "speed"             DOUBLE PRECISION,
    "eps"               DOUBLE PRECISION,
    "accuracy"          INTEGER,
    "phone"             TEXT,
    "work_status"       INTEGER
);

END TRANSACTION;
UPDATE client SET local_Event = 'Not Specified' WHERE local_Event IS NULL;
ALTER TABLE client ALTER COLUMN local_Event SET NOT NULL;
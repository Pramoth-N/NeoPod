select
    round(sum(LAT_N),4) Total
from
    STATION
where
    LAT_N < 137.2345 and LAT_N > 38.7880;

    
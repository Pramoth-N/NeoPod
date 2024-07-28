select
    Mov_Title Movie_Title
from
    movies m
join
    movie_cast c
on
    m.Mov_id = c.Mov_id
group by c.Mov_id
having
    count(c.Act_id) > 1;
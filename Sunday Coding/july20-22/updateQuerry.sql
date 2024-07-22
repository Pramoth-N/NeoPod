update rating set Rev_Stars = 3 where Mov_id = (
                                                    select
                                                        Mov_id
                                                    from
                                                        movies
                                                    where
                                                        Dir_id = (
                                                                select
                                                                    Dir_id
                                                                from
                                                                    director
                                                                where
                                                                    Dir_Name = "Lankesh"
                                                            )
                                                );

select * from rating;
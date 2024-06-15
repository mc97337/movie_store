package co.edu.poli.showtime.mapper;


public interface IMapper<I, O> {

    public O mapper(I in);
}
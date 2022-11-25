package Readers;

public interface Builder {
    void unArchiveZip(String archiveName);
    void unArchiveRar(String archiveName);
    void deCoding(String codingFileName);

    /*
    Идея:
    Создание билдера со всеми возможными архивациями, деархивациями, кодировками и декодировками,
    далее для каждого случая кодировки и архивации прописать метод, где используется паттерн проектирования Декоратор
    с помощью которого можно дополнять классы необходимыми методами для чтения архивации и кодинга
     */
}

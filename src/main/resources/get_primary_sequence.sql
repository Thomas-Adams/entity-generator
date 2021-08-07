create or replace function get_primary_sequence(t varchar, col varchar)
    returns varchar as $seq_name$
declare
    seq_name varchar;
begin
    begin
        select  pg_get_serial_sequence(t,col) into seq_name;
    exception
        when others then
            seq_name='';
    end;
    return seq_name;
end;
$seq_name$ language plpgsql;

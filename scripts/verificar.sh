#!/usr/bin/env bash
# Verifica que la salida de cada Demo (inicial y, si existe, solucion) coincide con salida-esperada.txt
set -uo pipefail
cd "$(dirname "$0")/.."
OUT=target/classes
JOPTS="-Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8"
mkdir -p "$OUT"
find src/main/java -name '*.java' > target/fuentes.txt
javac --release 17 -encoding UTF-8 -d "$OUT" @target/fuentes.txt || exit 1
BASE=edu.ingsoft.actividad.creacionales
fallos=0
for dir in casos/caso-*; do
  nn=$(basename "$dir" | cut -d- -f2)
  for variante in "" ".solucion"; do
    clase="$BASE.caso$nn$variante.Demo"
    ruta="src/main/java/$(echo "$clase" | sed 's#\.#/#g').java"
    [[ -f "$ruta" ]] || continue
    if diff -u "$dir/salida-esperada.txt" <(java $JOPTS -cp "$OUT" "$clase" 2>/dev/null) > /dev/null; then
      echo "OK     $clase"
    else
      echo "DIFIERE $clase"; fallos=$((fallos+1))
    fi
  done
done
exit $fallos

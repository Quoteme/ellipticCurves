#!/usr/bin/env bash
#
# @AUTHOR: Luca Leon Happel
# @DATE  : 2021-10-06 Mi 10:32 01
#
clj -m nrepl.cmdline \
    --middleware '["cider.nrepl/cider-middleware"]' \
    --interactive

package kg.example.mangalib.data.mapper

import kg.example.mangalib.domein.modelApi.DResult
import kg.example.mangalib.data.remote.modelApi.Result


fun DResult.toResult() = Result(
    chapters_quantity,
    created_at,
    description,
    dir,
    en_name,
    genre,
    id,
    image,
    issue_year,
    likes,
    rating,
    ru_name,
    type,
    updated_at
)
fun Result.toDResult() = DResult(
    chapters_quantity,
    created_at,
    description ?: "",
    dir,
    en_name,
    genre,
    id,
    image,
    issue_year,
    likes,
    rating,
    ru_name,
    type,
    updated_at
)